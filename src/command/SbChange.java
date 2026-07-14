package command;

public class SbChange extends Command {
	private Receiver r;
	public SbChange(Receiver r) {
		this.r = r;
	}

	public void execute() {
		r.sbhat();
	}

	public void redo() {
		this.execute();
	}

	public void undo() {
		this.execute();		
	}

}