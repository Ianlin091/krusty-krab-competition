package command;

public class SbChangeHat2 extends Command {
	private Receiver r;
	public SbChangeHat2(Receiver r) {
		this.r = r;
	}

	public void execute() {
		r.sbhat2();
	}

	public void redo() {
		this.execute();
	}

	public void undo() {
		this.execute();
	}

}