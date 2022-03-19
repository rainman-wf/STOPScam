package bot;

public class Constants {
    public static final long ADMIN_ID = 5120189161L;
    public static final long TIMEOUT = 1000 * 60 * 60;
    public static final int MSGPACK_SIZE = 5;
    public static final String TOKEN = "5177036357:AAHfT4N39iOR-O8eZ52veilPILr4kaNPDHs";

    public static final String BEGIN = "/begin";
    public static final String SEND = "/send";
    public static final String BREAK = "/break";
    public static final String HELP = "/help";

    public static final String BREAK_BTN_LABEL = "Завершить";
    public static final String RESUME_BTN_LABEL = "Продолжить";
    public static final String ACCEPT_BTN_LABEL = "Принять";
    public static final String EDIT_BTN_LABEL = "Редактировать";
    public static final String DENY_BTN_LABEL = "Отклонить";

    public static final String DATA_SPLITTER = ":";
    public static final String BREAK_DATA = "break";
    public static final String RESUME_DATA = "resume";
    public static final String ACCEPT_DATA = "accept";
    public static final String EDIT_DATA = "edit";
    public static final String DENY_DATA = "deny";

    public static final String PROGRESS_BRAKED_MSG =
            "Прогресс обнулен, сообщения удалены.";

    public static final String PROGRESS_RESUMED_MSG =
            "Продолжаем дальше.";

    public static final String ADMIN_ACCEPT_MSG =
            "\u2705 Прниято к публикации.";

    public static final String ADMIN_EDIT_MSG =
            "\uD83D\uDCDD Отправлено на доработку.";

    public static final String ADMIN_DENY_MSG =
            "\u274c Отклонено.";

    public static final String MSGPACK_SIZE_LIMIT_MSG =
            "Нельзя отправлять более 5 сообщений в пакете.\n" +
                    "Все дальнейшие сообщения будут удаляться.";

    public static final String INPUT_BEGIN_MSG =
            "Введите " + BEGIN + " для начала.";

    public static final String BREAK_REQUEST_MSG =
            "Все набранные в данной сессии сообщения будут удалены.\n" +
                    "Ваш прогресс будет утерян.\n" +
                    "Вы уверены?";

    public static final String PROCESS_NOT_STARTED_MSG =
            "Процедура не была запущена.";

    public static final String TIMEOUT_LIMIT_MSG =
            "Нельзя отправлять сообщения " +
                    "чаще, чем 1 раз в час.\nОжидайте ";

    public static final String LETS_BEGIN_MSG =
            "\nДавай начнем! " +
                    "\nМожешь ввести не более 5 сообщений." +
                    "\nДопустимо редактировать сообщения, но нельзя удалять.";

    public static final String PROCESS_ALREADY_RUNNING_MSG =
            "Процедура набора сообщений уже запущена.";

    public static final String NOTHING_TO_SEND_MSG =
            "Нечего отправлять. Наберите хотя бы одно сообщение.";

    public static final String MSGPACK_SENT_MSG =
            "\u2705 Сообщения были отправлены\nОжидайте ответа администратора.";

    public static final String MSGPACK_ACCEPTED_MSG =
            "Ваша история будет опубликована.";

    public static final String MSGPACK_NEED_EDITING_MSG =
            "Отредакутируйте ваше сообщение согласно правилам оформления.";

    public static final String MSGPACK_DENIED_MSG =
            "Ваша история была отклонена.";

    public static final String CHOICE_ACTION_MSG =
            "Выберите действие.";

    public static final String HELLO =
            "Привет ";

    public static final String README =
            "<p>Бот позволяет отправить заявку на публикацию твоей истории на канале <a href=\"https://t.me/+qGVq3mfNQrFjOTdi\">СТОП! Кидалово</a>.<br />Можно отправить пакет из 5 сообщений не чаще чем 1 раз в час.</p>\n" +
                    "<p><strong>Инструкция по исплозованию бота:</strong></p>\n" +
                    "<ol>\n" +
                    "<li>Чтобы начать набирать сообщения, необходимо из меню вызвать команду /begin.</li>\n" +
                    "<li>Далее следует набрать сообщения, которые могут содержать фотографии, видео и просто текст (от 1 до 5).</li>\n" +
                    "<li>Когда будет набрано 5 сообщений, бот сообщит об ограничении, и дальнейшие сообщения будт мгновенно удаляться. Поэтому важно это учитывать и сразу правильно заполнять заявку согласно правилам оформления.</li>\n" +
                    "<li>Набранные в рамках текущей процедуры сообщения допустимо редактировать, однако нельзя удалять, т.к. удаленные собщения бот все равно сохранит и перешлет.</li>\n" +
                    "<li>После того, как будет оформлен пакет сообщений, необходимо из меню вызвать команду /send, после чего весь пакет сообщений будет отправлен менеджеру канала.</li>\n" +
                    "<li>Отправка сообщений автоматически завершит процедуру, и можно будет начать новую выбрав из меню команду /begin. Однако отправка сообщений командой /send будет недоступна в течении 1 часа. При попытке отправить пакет бот будет сообщать об этом и показывать оставшееся время ожидания.</li>\n" +
                    "<li>Менеджер канала может принять вашу заявку на публикацию, попросить оформить заявку согласно правилам оформления, или отклонить заявку без указания причины.</li>\n" +
                    "<li>Команда /break позволяет сбросить весь прогресс процедуры, удалить все набранные в рамках текущей процедуры сообщения. Чтобы начать новую процедуру, необходимо из меню вызвать команду /begin.</li>\n" +
                    "</ol>\n" +
                    "<p>Правила оформления заявки:</p>";
}
