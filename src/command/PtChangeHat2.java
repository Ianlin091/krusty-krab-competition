package command;

public class PtChangeHat2 extends Command {
	private Receiver r;
	public PtChangeHat2(Receiver r) {
		this.r = r;
	}

	public void execute() {
		r.pthat2();
	}

	public void redo() {
		this.execute();
	}

	public void undo() {
		this.execute();
	}

}
