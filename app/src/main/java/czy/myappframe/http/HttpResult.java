package czy.myappframe.http;

/**
 * Created by george on 2016/11/28.
 */

public class HttpResult<T> {
    public String Success;
    public String ErrorText;
    public String MsgType;
    public String RowCount;
    public String Status;
    public T DataValue;

}
