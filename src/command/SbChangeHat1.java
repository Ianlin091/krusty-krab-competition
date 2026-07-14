package command;

public class SbChangeHat1 extends Command {
	private Receiver r;
	public SbChangeHat1(Receiver r) {
		this.r = r;
	}

	public void execute() {
		r.sbhat1();
	}

	public void redo() {
		this.execute();
	}

	public void undo() {
		this.execute();
	}

}