package utilities;

import java.net.UnknownHostException;
import java.util.List;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoConnection
{
	public static final String HOST = "localhost"; // database host
	public static final int PORT = 27017; // database port
	public static final String DB_NAME = "Thesis"; // database name
	private String COLLECTION_NAME = "CollectionDefault";
	private MongoClient mongo;
	private DB db;
	private DBCollection table;
	
	@ SuppressWarnings ("unused")
	private int status; // 0 for not initialized, 1 for initialized, -1 for
						// error

	public MongoConnection()
	{
		this.status = 0;
	}

	public void setCollectionName(String collectionName)
	{
		this.COLLECTION_NAME = collectionName;
	}

	// Setup the Connection with the Database
	public void setupMongo()
	{
		this.mongo = new MongoClient(HOST, PORT);
		this.db = this.mongo.getDB(DB_NAME);
		this.table = db.getCollection(COLLECTION_NAME);
		this.status = 1;
	}

	public void insert(DBObject object)
	{
		this.table.insert(object);
	}

	public void insert(List<DBObject> objects)
	{
		this.table.insert(objects);
	}

	public void disconnect()
	{
		this.mongo.close();
	}
	
}