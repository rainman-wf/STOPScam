package bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.ForwardMessage;
import com.pengrad.telegrambot.request.SendMessage;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bot {

    private final long ADMIN_ID = 1645169713;
    private final String TOKEN = "5177036357:AAHfT4N39iOR-O8eZ52veilPILr4kaNPDHs";
    private final TelegramBot bot = new TelegramBot(TOKEN);

    private final Map<Long, ArrayList<Integer>> senders = new HashMap<>();
    private final Map<Long, Long> timeout = new HashMap<>();

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
                        case "/start":
                            if (!senders.containsKey(senderID)) {
                                senders.put(senderID, new ArrayList<>());
                                bot.execute(new SendMessage(senderID, "Let's begin"));
                            } else {
                                bot.execute(new SendMessage(senderID, "you in process right now"));
                            }
                            return;
                        case "/send":
                            if (senders.containsKey(senderID)) {

                                if (timeout.containsKey(senderID)) {
                                    if (new Date().getTime() < timeout.get(senderID)) {
                                        int time = (int) ((timeout.get(senderID) - new Date().getTime()) / 1000);
                                        int minutes = time / 60;
                                        int seconds = time % 60;
                                        bot.execute(new SendMessage(senderID, "You cannot send messages " +
                                                "more than once per hour\nwait for " + minutes + " m " + seconds + " s"));
                                        return;
                                    } else {
                                        timeout.remove(senderID);
                                        sendMsgPack(senderID);
                                    }
                                } else {
                                    sendMsgPack(senderID);
                                }
                            }
                            return;
                        case "/help":
                            bot.execute(new SendMessage(senderID, "Help information must be here"));
                            return;
                    }
                }

                if (senders.containsKey(senderID)) {
                    ArrayList<Integer> idList = senders.get(senderID);
                    if (idList.size() > 5) {
                        bot.execute(new SendMessage(senderID, "You can send no more than 5 messages"));
                    } else {
                        idList.add(messageID);
                    }
                } else {
                    bot.execute(new SendMessage(senderID, "Send /start to begin"));
                }
            }
        }

        if (callbackQuery != null) {
            String[] data = callbackQuery.data().split(" ");

            String action = data[0];
            long senderID = Long.parseLong(data[1]);

            bot.execute(sendResponseToSender(senderID, action));

        }
    }

    private void sendMsgPack(long senderID) {
        ArrayList<Integer> idList = senders.get(senderID);
        if (idList.size() == 0) {
            bot.execute(new SendMessage(senderID, "Nothing to send"));
        } else {
            idList.forEach(id -> bot.execute(new ForwardMessage(ADMIN_ID, senderID, id)));
            senders.remove(senderID);
            timeout.put(senderID, new Date().getTime() + 3600000L);
            bot.execute(sendActionChoice(senderID));
        }
    }

    private SendMessage sendActionChoice(long senderID) {
        return new SendMessage(ADMIN_ID, "Choice action")
                .replyMarkup(new InlineKeyboardMarkup(
                        new InlineKeyboardButton("Accept").callbackData("accept " + senderID),
                        new InlineKeyboardButton("Edit").callbackData("edit " + senderID),
                        new InlineKeyboardButton("Deny").callbackData("deny " + senderID)));
    }

    @NotNull
    @Contract("_, _ -> new")
    private SendMessage sendResponseToSender(long senderID, @NotNull String response) {
        String text = null;

        switch (response) {
            case "accept":
                text = "Your post is accepted";
                break;
            case "edit":
                text = "Look message formatting rules, and try again";
                break;
            case "deny":
                text = "Your content is not suitable for publication";
                break;
        }
        return new SendMessage(senderID, text);
    }

}
