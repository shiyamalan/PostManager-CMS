package local.cms.web.models;

/***
 * To manage the post status
 * 
 * @author shiyam
 * @since 1.0.0
 * @version 1.0.0
 */
public enum Status {

	Draft, ReadyPublish, Reject, Published, Archived;

	private static Status[] vals = values();
	public Status next() {
		return vals[(this.ordinal() + 1) % vals.length];
	}

	public Status[] getValues() {
		return Status.values();
	}
}
