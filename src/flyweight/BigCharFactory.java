package flyweight;

import java.util.HashMap;

public class BigCharFactory {
    private HashMap pool = new HashMap();
    private static BigCharFactory singleton = new BigCharFactory();

    public BigCharFactory() {
    }

    public static BigCharFactory getInstance() {
        if(singleton == null) singleton = new BigCharFactory();
        return singleton;
    }

    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = (BigChar) pool.get("" + charname);
        if (bc == null) {
            bc = new BigChar(charname);
            pool.put(""+charname, bc);
        }
        return bc;
    }
}
