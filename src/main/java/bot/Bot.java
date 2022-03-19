package bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.DeleteMessage;
import com.pengrad.telegrambot.request.EditMessageText;
import com.pengrad.telegrambot.request.ForwardMessage;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static bot.Constants.*;

public class Bot {

    private final TelegramBot bot = new TelegramBot(TOKEN);

    private final Map<Long, ArrayList<Integer>> senders = new HashMap<>();
    private final Map<Long, Long> timeLimitedUsers = new HashMap<>();
    private final Map<Long, Integer> deleteRequestMsg = new HashMap<>();
    private final Map<Long, Integer> actionRequestMsg = new HashMap<>();

    public void listen() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private void process(@NotNull Update update) {

        CallbackQuery callbackQuery = update.callbackQuery();
        Message message = update.message();

        if (message != null) {

            int messageID = message.messageId();
            long senderID = message.from().id();

            if (senderID != ADMIN_ID) {
                if (message.text() != null) {
                    switch (message.text()) {
                        case BEGIN:
                            processBegin(message, senderID);
                            return;
                        case SEND:
                            processSend(senderID);
                            return;
                        case HELP:
                            sendMessage(senderID, README, ParseMode.HTML);
                            return;
                        case BREAK:
                            processBreak(senderID);
                            return;
                    }
                }
                limitMessages(messageID, senderID);
            }
        }

        if (callbackQuery != null) {
            long senderID = callbackQuery.from().id();
            if (senderID == ADMIN_ID) {
                adminHandlingResult(callbackQuery);
            } else {
                userHandlingResult(callbackQuery, senderID);
            }
        }
    }

    private void processSend(long senderID) {
        if (senders.containsKey(senderID)) {
            if (timeLimitedUsers.containsKey(senderID)) {
                if (new Date().getTime() < timeLimitedUsers.get(senderID)) {
                    sendTimeoutReport(senderID);
                } else {
                    timeLimitedUsers.remove(senderID);
                    sendMsgPack(senderID);
                }
            } else {
                sendMsgPack(senderID);
            }
        }
    }

    private void userHandlingResult(CallbackQuery callbackQuery, long senderID) {
        String data = callbackQuery.data();
        switch (data) {
            case BREAK_DATA:
                senders.get(senderID).forEach(msg -> bot.execute(new DeleteMessage(senderID, msg)));
                senders.remove(senderID);
                bot.execute(new EditMessageText(senderID,
                        deleteRequestMsg.get(senderID), PROGRESS_BRAKED_MSG));
                break;
            case RESUME_DATA:
                bot.execute(new EditMessageText(senderID,
                        deleteRequestMsg.get(senderID), PROGRESS_RESUMED_MSG));
                break;
        }
    }

    private void adminHandlingResult(CallbackQuery callbackQuery) {
        String[] data = callbackQuery.data().split(DATA_SPLITTER);

        String action = data[0];
        long recipientID = Long.parseLong(data[1]);

        sendResponseToSender(recipientID, action);

        String text = null;

        switch (action) {
            case ACCEPT_DATA:
                text = ADMIN_ACCEPT_MSG;
                break;
            case EDIT_DATA:
                text = ADMIN_EDIT_MSG;
                break;
            case DENY_DATA:
                text = ADMIN_DENY_MSG;
                break;
        }
        bot.execute(new EditMessageText(ADMIN_ID, actionRequestMsg.get(recipientID), text));
        actionRequestMsg.remove(recipientID);
    }

    private void limitMessages(int messageID, long senderID) {
        if (senders.containsKey(senderID)) {
            ArrayList<Integer> idList = senders.get(senderID);
            if (idList.size() >= MSGPACK_SIZE) {
                bot.execute(new DeleteMessage(senderID, messageID));
            } else {
                idList.add(messageID);
                if (idList.size() == MSGPACK_SIZE) {
                    sendMessage(senderID, MSGPACK_SIZE_LIMIT_MSG);
                }
            }
        } else {
            sendMessage(senderID, INPUT_BEGIN_MSG);
        }
    }

    private void processBreak(long senderID) {
        if (senders.containsKey(senderID)) {
            SendResponse response = sendMessage(senderID, BREAK_REQUEST_MSG, userHandler());
            deleteRequestMsg.put(senderID, response.message().messageId());
        } else {
            sendMessage(senderID, PROCESS_NOT_STARTED_MSG);
        }
    }


    private void sendTimeoutReport(long senderID) {
        int time = (int) ((timeLimitedUsers.get(senderID) - new Date().getTime()) / TIMEOUT);
        int minutes = time / 60;
        int seconds = time % 60;
        sendMessage(senderID,
                TIMEOUT_LIMIT_MSG + (minutes > 0 ? minutes : "") + " мин " + seconds + " сек");
    }

    private void processBegin(Message message, long senderID) {
        if (!senders.containsKey(senderID)) {
            senders.put(senderID, new ArrayList<>());
            sendMessage(senderID, HELLO + message.from().firstName() + LETS_BEGIN_MSG);
        } else {
            sendMessage(senderID, PROCESS_ALREADY_RUNNING_MSG);
        }
    }

    private void sendMsgPack(long senderID) {
        ArrayList<Integer> idList = senders.get(senderID);
        if (idList.size() == 0) {
            sendMessage(senderID, NOTHING_TO_SEND_MSG);
        } else {
            idList.forEach(id -> bot.execute(new ForwardMessage(ADMIN_ID, senderID, id)));
            senders.remove(senderID);
            timeLimitedUsers.put(senderID, new Date().getTime() + TIMEOUT);
            SendResponse response = sendMessage(ADMIN_ID, CHOICE_ACTION_MSG, adminHandler(senderID));
            actionRequestMsg.put(senderID, response.message().messageId());
            sendMessage(senderID, MSGPACK_SENT_MSG);
        }
    }

    void sendMessage(long chatID, String msg) {
        bot.execute(new SendMessage(chatID, msg));
    }

    void sendMessage(long chatID, String msg, ParseMode parseMode) {
        bot.execute(new SendMessage(chatID, msg).parseMode(parseMode));
    }

    SendResponse sendMessage(long chatID, String msg, InlineKeyboardMarkup markup) {
        return bot.execute(new SendMessage(chatID, msg).replyMarkup(markup));
    }

    void sendResponseToSender(long senderID, @NotNull String response) {
        String text = null;
        switch (response) {
            case ACCEPT_DATA:
                text = MSGPACK_ACCEPTED_MSG;
                break;
            case EDIT_DATA:
                text = MSGPACK_NEED_EDITING_MSG;
                break;
            case DENY_DATA:
                text = MSGPACK_DENIED_MSG;
                break;
        }
        sendMessage(senderID, text);
    }

    @NotNull
    private InlineKeyboardMarkup adminHandler(long senderID) {
        return new InlineKeyboardMarkup(
                adminHandlerBtn(ACCEPT_BTN_LABEL, ACCEPT_DATA, senderID),
                adminHandlerBtn(EDIT_BTN_LABEL, EDIT_DATA, senderID),
                adminHandlerBtn(DENY_BTN_LABEL, DENY_DATA, senderID));
    }

    private InlineKeyboardButton adminHandlerBtn(String label, String data, long senderID) {
        return handlerBtn(label, data + DATA_SPLITTER + senderID);
    }

    @NotNull
    private InlineKeyboardMarkup userHandler() {
        return new InlineKeyboardMarkup(
                handlerBtn(BREAK_BTN_LABEL, BREAK_DATA),
                handlerBtn(RESUME_BTN_LABEL, RESUME_DATA));
    }

    private InlineKeyboardButton handlerBtn(String breakBtnLabel, String breakData) {
        return new InlineKeyboardButton(breakBtnLabel).callbackData(breakData);
    }

}
