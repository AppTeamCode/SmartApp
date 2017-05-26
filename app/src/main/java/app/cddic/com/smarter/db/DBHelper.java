package app.cddic.com.smarter.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.cddic.com.smarter.entity.ConnectMsg;
import app.cddic.com.smarter.entity.MsgObject;
import app.cddic.com.smarter.entity.RegisterMSG;
import app.cddic.com.smarter.utils.StaticClass;


/**
 * 项目名：  SmartApp
 * 包名：    app.cddic.com.smarter.db
 * 文件名：  DBHelper
 * 创建者：
 * 创建时间： 2017/4/17 10:59
 * 描述：
 */


public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private static String DB_NAME = "smartapp.db"; //数据库名
    private static int version = 1; //版本号
    //表名
    private final String ACCOUNT = "account";
    private final String DEVICE = "device";
    private final String ALARM = "alarm";
    private final String DOCUMENT = "document";
    private final String RELATER = "relater";
    private final String CHAT = "chat";
    private final String NOTICE = "notice";
    private final String CONTACT = "contact";
    private final String SETTING = "setting";




    //自己定义的构造方法,调用父类的构造方法
    public DBHelper(Context mContext){
        super(mContext,DB_NAME,null,version);
        db = this.getWritableDatabase();
    }

    /**
     * 数据库创建时使用
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("test","成功创建数据库~~~~~~~");
        //1用户账号表(Account)
        String sql1 = "create table account"
                + "(username varchar(20) not null"
                + ",password varchar(20) not null"
                + ",uid integer"
                + ",phonenum varchar(20)"
                + ",nickname varchar(20)"
                + ",sex byte"
                + ",time varchar(30)"
                + ",type byte"
                + ",email varchar(20)"
                + ",state byte"
                + ",did integer)";

        //1用户设备表信息记录表(Device)
        String sql2 = "create table device"
                + "(uid integer not null"
                + ",devname varchar(20) not null"
                + ",serial varchar(30)"
                + ",code varchar(16)"
                + ",ipaddr integer"
                + ",alias varchar(20)"
                + ",user varchar(20)"
                + ",pass varchar(20)"
                + ",power byte"
                + ",type byte"
                + ",plugin varchar(20)"
                + ",did integer"
                + ",version varchar(10)"
                + ",time varchar(30)"
                + ",longitude float"
                + ",latitude float"
                + ",state byte)";

        //3报警信息表(alarm)
        String sql3 = "create table alarm"
                + "(id integer not null"
                + ",serial varchar(30) not null"
                + ",type byte not null"
                + ",level byte not null"
                + ",time varchar(30) not null"
                + ",url varchar(20)"
                + ",lurl varchar(20)"
                + ",state byte)";

        //4设备附属文件表(document)
        String sql4 = "create table document"
                + "(id integer not null"
                + ",serial varchar(30) not null"
                + ",type byte not null"
                + ",time varchar(30) not null"
                + ",url varchar(20))";

        //5设备关联人表(relater)
        String sql5 = "create table relater"
                + "(username varchar(20) not null"
                + ",id integer not null"
                + ",power byte not null"
                + ",time varchar(30)"
                + ",type byte"
                + ",alias varchar(20))";

        //6我的聊天消息表(chat)
        String sql6 = "create table chat"
                + "(musername varchar(20) not null"
                + ",mid integer not null"
                + ",id integer not null"
                + ",username varchar(20) not null"
                + ",type byte not null"
                + ",time varchar(30) not null"
                + ",content varchar(100) not null"
                + ",state byte)";

        //7我收到的通知信息表(notice)
        String sql7 = "create table notice"
                + "(username varchar(20) not null"
                + ",id integer not null"
                + ",type byte not null"
                + ",time varchar(30) not null"
                + ",message varchar(100)"
                + ",state byte"
                + ",serial varchar(30) not null"
                + ",power byte"
                + ",grps varchar(10)"
                + ",title varchar(50))";

        //8我的联系人信息表(contact)
        String sql8 = "create table contact"
                + "(username varchar(20) not null"
                + ",id integer not null"
                + ",contact varchar(20) not null"
                + ",type byte not null"
                + ",sex byte not null"
                + ",alias varchar(20)"
                + ",online byte"
                + ",settime varchar(30)"
                + ",grps varchar(10))";

        //9用户设置表(setting)未完成
        String sql9  = "create table setting"
                + "(username varchar(20) not null"
                + ",id integer not null"
                + ",sound byte)";

        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
        db.execSQL(sql7);
        db.execSQL(sql8);
        db.execSQL(sql9);

    }

    //封装增删查改的方法
    public void addData(MsgObject msgObject){
        int msgType = msgObject.getType();
        ContentValues content = new ContentValues();
        switch (msgType){
            //注册信息(用户个人信息)
            case StaticClass.MSG_REGISTER:
                RegisterMSG msg = (RegisterMSG) msgObject;
                content.put("username",msg.getUsername());
                content.put("password",msg.getPassword());
                content.put("uid",msg.getUid());
                content.put("sex",msg.getSex());
                content.put("time",msg.getTime());
                content.put("type",msg.getsType());
                content.put("email",msg.getEmail());
                content.put("state",msg.getState());
                content.put("did",msg.getDid());
                db.insert(ACCOUNT,null,content);
                Log.i("Dababase","添加数据成功");
                db.close();
                break;
            case 2:
                break;
            case 3:
                break;
        }

    }

    public List<MsgObject> findData(int mType){
        switch (mType){
            case 1:
                List<MsgObject> dataList = new ArrayList<>();
                Cursor cur = db.query(ACCOUNT,new String[]{"uid","username","password"},null,null,null,null,null);
                while (cur.moveToNext()) {
                    for (int i = 0; i < cur.getCount(); i++) {
                        cur.moveToPosition(i);
                        ConnectMsg connectMsg = new ConnectMsg();
                        connectMsg.setUsername(cur.getString(cur.getColumnIndex("username")));
                        connectMsg.setPassword(cur.getString(cur.getColumnIndex("password")));
                        dataList.add(connectMsg);
                    }
                }
                cur.close();
                db.close();
                return dataList;
            case 2:
                return null;
        }
        return null;
    }


    /**
     * 更新时使用
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
