package bot;

public class Constants {
    public static final long ADMIN_ID = 1645169713;
    public static final long TIMEOUT = 1000;
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

    public static final String INPUT_BEGIN_MSG =
            "Нажми " + BEGIN + " для начала.";

    public static final String BREAK_REQUEST_MSG =
            "Все набранные в данной сессии сообщения будут удалены.\n" +
                    "Ваш прогресс будет утерян.\n" +
                    "Вы уверены?";

    public static final String PROCESS_NOT_STARTED_MSG =
            "Процедура не была запущена.\n" + INPUT_BEGIN_MSG;

    public static final String TIMEOUT_LIMIT_MSG =
            "Нельзя отправлять заявку чаще, чем 1 раз в час.\nОжидайте ";

    public static final String LETS_BEGIN_MSG =
            "\nДавай начнем! " +
                    "\nПрикрепи скриншоты одним файлом в коллаже без какого-либо описания.";

    public static final String PROCESS_ALREADY_RUNNING_MSG =
            "Процедура набора сообщений уже запущена.";

    public static final String NOTHING_TO_SEND_MSG =
            "Заполни заявку согласно правилам оформления.";

    public static final String MSGPACK_SENT_MSG =
            "\u2705 Сообщения были отправлены\nОжидайте ответа менеджара канала.";

    public static final String MSGPACK_ACCEPTED_MSG =
            "Ваша история будет опубликована в ближайшее время.";

    public static final String MSGPACK_NEED_EDITING_MSG =
            "Отредакутируйте ваше сообщение согласно правилам оформления.";

    public static final String MSGPACK_DENIED_MSG =
            "Ваша история была отклонена.";

    public static final String CHOICE_ACTION_MSG =
            "Выберите действие.";

    public static final String HELLO =
            "Привет ";

    public static final String ONLY_SCREENSHOT_ERROR_MSG =
            "Допускается отправить только скринишот.";

    public static final String ONLY_ONE_FILE_ERROR_MSG =
            "Допускается только один скриншот.";

    public static final String ONLY_TEXT_ERROR_MSG =
            "Допускается отправить только текст.";

    public static final String CAPTION_FREE_ERROR_MSG =
            "У скриншота не должно быть описания.";

    public static final String INPUT_TEXT_MSG =
            "Отлично! Теперь пришли мне историю в одном текстовом сообщении.\n" +
                    "Сообщение не должно содержать медиа (фото, видео, и т.д.)";

    public static final String INPUT_SEND_MSG =
            "Отлично! Заявка готова к отправке.\n" +
                    "Проверь еще раз текст и отправь заявку, вызвав из меню команду /send.\n" +
                    "Дальнейшие сообщения будут удаляться.";

    public static final String README =
            "Бот позволяет отправить заявку на публикацию твоей истории на канале " +
                    "<a href=\"https://t.me/+qGVq3mfNQrFjOTdi\">СТОП! Кидалово</a>.\n" +
                    "\n" +
                    "Заявку можно отправлять не чаще чем 1 раз в час.\n" +
                    "\n" +
                    "<b><u>Инструкция по исплозованию бота:</u></b>\n" +
                    "\n" +
                    "1. Вызвать из меню команду /begin.\n" +
                    "2. Прикрепить скриншот <b><u>ОДНИМ ФАЙЛОМ В ВИДЕ КОЛЛАЖА</u></b> без какого либо описания.\n" +
                    "3. Написать текст истории <b><u>ОДНИМ ОТДЕЛЬНЫМ СООБЩЕНИЕМ</u></b>\n" +
                    "4. Вызвать из меню команду /send.\n" +
                    "\n" +
                    "<i>В результате должно быть два сообщения c одним сриншотом и одним текстовым сообщением.</i>\n" +
                    "\n" +
                    "* Набранные в рамках текущей процедуры сообщения допустимо редактировать и не рекомендуется удалять. " +
                    "Если ты допустил(а) какую-либо ошибку, следует сбросить продцедуру командой /break, и начать новую, как описано выше.\n" +
                    "\n" +
                    "* После того, как была отправлена заявка, бот автоматически сбросит процедуру, и ты сможешь приступить к оформлению новой заявки, " +
                    "однако отправка командой /send будет надоступна в течении 1 часа. Бот сообщит о запущенном таймере и покажет оставшееся время ожидания.\n" +
                    "\n" +
                    "* Менеджер канала может принять вашу заявку на публикацию, попросить оформить заявку согласно правилам оформления, или отклонить заявку без указания причины.\n" +
                    "\n" +
                    "Отзывы, связанные с рекламой, бертером, взаимоотношениями между блогерами и написанные не по правилам — НЕ ПРИНИМАЮТСЯ\n" +
                    "\n" +
                    "\uD83D\uDC64 Все истории присланы участниками и администрация канала не несет ответственность за репутацию обеих сторон после публикации присылаемых историй";
}
