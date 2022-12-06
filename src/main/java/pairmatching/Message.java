package pairmatching;

public enum Message {
	MENU("기능을 선택하세요.\n" +
			"1. 페어 매칭\n" +
			"2. 페어 조회\n" +
			"3. 페어 초기화\n" +
			"Q. 종료");

	Message(String msg) {
		this.msg = msg;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}
}
