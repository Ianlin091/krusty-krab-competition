package state;

public class StateContext {

	private AbsState stateconcrete;
	private static String state;
	
	public StateContext(){
		this.stateconcrete = new StatePrestart();
	}
	// 設定狀態
	public void setState(AbsState state) {
		stateconcrete = state;
	}

	// 讀取狀態
	public String getState() {
		return state;
	}

	// 處理請求
	public void execution(StateContext context) {
		stateconcrete.execute(context);
	}
}
