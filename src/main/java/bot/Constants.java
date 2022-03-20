package bot;

public class Constants {
    public static final long ADMIN_ID = 1645169713;
    public static final long TIMEOUT = 1000;
    public static final String TOKEN = "5177036357:AAHfT4N39iOR-O8eZ52veilPILr4kaNPDHs";

    public static final String BEGIN = "/begin";
    public static final String SEND = "/send";
    public static final String BREAK = "/break";
    public static final String HELP = "/help";

    public static final String BREAK_BTN_LABEL = "���������";
    public static final String RESUME_BTN_LABEL = "����������";
    public static final String ACCEPT_BTN_LABEL = "�������";
    public static final String EDIT_BTN_LABEL = "�������������";
    public static final String DENY_BTN_LABEL = "���������";

    public static final String DATA_SPLITTER = ":";
    public static final String BREAK_DATA = "break";
    public static final String RESUME_DATA = "resume";
    public static final String ACCEPT_DATA = "accept";
    public static final String EDIT_DATA = "edit";
    public static final String DENY_DATA = "deny";

    public static final String PROGRESS_BRAKED_MSG =
            "�������� �������, ��������� �������.";

    public static final String PROGRESS_RESUMED_MSG =
            "���������� ������.";

    public static final String ADMIN_ACCEPT_MSG =
            "\u2705 ������� � ����������.";

    public static final String ADMIN_EDIT_MSG =
            "\uD83D\uDCDD ���������� �� ���������.";

    public static final String ADMIN_DENY_MSG =
            "\u274c ���������.";

    public static final String INPUT_BEGIN_MSG =
            "����� " + BEGIN + " ��� ������.";

    public static final String BREAK_REQUEST_MSG =
            "��� ��������� � ������ ������ ��������� ����� �������.\n" +
                    "��� �������� ����� ������.\n" +
                    "�� �������?";

    public static final String PROCESS_NOT_STARTED_MSG =
            "��������� �� ���� ��������.\n" + INPUT_BEGIN_MSG;

    public static final String TIMEOUT_LIMIT_MSG =
            "������ ���������� ������ ����, ��� 1 ��� � ���.\n�������� ";

    public static final String LETS_BEGIN_MSG =
            "\n����� ������! " +
                    "\n�������� ��������� ����� ������ � ������� ��� ������-���� ��������.";

    public static final String PROCESS_ALREADY_RUNNING_MSG =
            "��������� ������ ��������� ��� ��������.";

    public static final String NOTHING_TO_SEND_MSG =
            "������� ������ �������� �������� ����������.";

    public static final String MSGPACK_SENT_MSG =
            "\u2705 ��������� ���� ����������\n�������� ������ ��������� ������.";

    public static final String MSGPACK_ACCEPTED_MSG =
            "���� ������� ����� ������������ � ��������� �����.";

    public static final String MSGPACK_NEED_EDITING_MSG =
            "��������������� ���� ��������� �������� �������� ����������.";

    public static final String MSGPACK_DENIED_MSG =
            "���� ������� ���� ���������.";

    public static final String CHOICE_ACTION_MSG =
            "�������� ��������.";

    public static final String HELLO =
            "������ ";

    public static final String ONLY_SCREENSHOT_ERROR_MSG =
            "����������� ��������� ������ ���������.";

    public static final String ONLY_ONE_FILE_ERROR_MSG =
            "����������� ������ ���� ��������.";

    public static final String ONLY_TEXT_ERROR_MSG =
            "����������� ��������� ������ �����.";

    public static final String CAPTION_FREE_ERROR_MSG =
            "� ��������� �� ������ ���� ��������.";

    public static final String INPUT_TEXT_MSG =
            "�������! ������ ������ ��� ������� � ����� ��������� ���������.\n" +
                    "��������� �� ������ ��������� ����� (����, �����, � �.�.)";

    public static final String INPUT_SEND_MSG =
            "�������! ������ ������ � ��������.\n" +
                    "������� ��� ��� ����� � ������� ������, ������ �� ���� ������� /send.\n" +
                    "���������� ��������� ����� ���������.";

    public static final String README =
            "��� ��������� ��������� ������ �� ���������� ����� ������� �� ������ " +
                    "<a href=\"https://t.me/+qGVq3mfNQrFjOTdi\">����! ��������</a>.\n" +
                    "\n" +
                    "������ ����� ���������� �� ���� ��� 1 ��� � ���.\n" +
                    "\n" +
                    "<b><u>���������� �� ������������ ����:</u></b>\n" +
                    "\n" +
                    "1. ������� �� ���� ������� /begin.\n" +
                    "2. ���������� �������� <b><u>����� ������ � ���� �������</u></b> ��� ������ ���� ��������.\n" +
                    "3. �������� ����� ������� <b><u>����� ��������� ����������</u></b>\n" +
                    "4. ������� �� ���� ������� /send.\n" +
                    "\n" +
                    "<i>� ���������� ������ ���� ��� ��������� c ����� ��������� � ����� ��������� ����������.</i>\n" +
                    "\n" +
                    "* ��������� � ������ ������� ��������� ��������� ��������� ������������� � �� ������������� �������. " +
                    "���� �� ��������(�) �����-���� ������, ������� �������� ���������� �������� /break, � ������ �����, ��� ������� ����.\n" +
                    "\n" +
                    "* ����� ����, ��� ���� ���������� ������, ��� ������������� ������� ���������, � �� ������� ���������� � ���������� ����� ������, " +
                    "������ �������� �������� /send ����� ���������� � ������� 1 ����. ��� ������� � ���������� ������� � ������� ���������� ����� ��������.\n" +
                    "\n" +
                    "* �������� ������ ����� ������� ���� ������ �� ����������, ��������� �������� ������ �������� �������� ����������, ��� ��������� ������ ��� �������� �������.\n" +
                    "\n" +
                    "������, ��������� � ��������, ��������, ����������������� ����� ��������� � ���������� �� �� �������� � �� �����������\n" +
                    "\n" +
                    "\uD83D\uDC64 ��� ������� �������� ����������� � ������������� ������ �� ����� ��������������� �� ��������� ����� ������ ����� ���������� ����������� �������";
}
