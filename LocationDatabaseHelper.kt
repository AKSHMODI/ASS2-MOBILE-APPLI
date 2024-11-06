class LocationDatabaseHelper{
    import android.content.ContentValues
    import android.content.Context
    import android.database.Cursor
    import android.database.sqlite.SQLiteDatabase
    import android.database.sqlite.SQLiteOpenHelper

    class LocationDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        companion object {
            // Database name and version
            private const val DATABASE_NAME = "location_database"
            private const val DATABASE_VERSION = 1

            // Table and column names
            private const val TABLE_NAME = "locations"
            private const val COL_ID = "id"
            private const val COL_ADDRESS = "address"
            private const val COL_LATITUDE = "latitude"
            private const val COL_LONGITUDE = "longitude"
        }

        // This is called when the database is created for the first time
        override fun onCreate(db: SQLiteDatabase?) {
            // SQL query to create the table
            val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_ADDRESS TEXT,
                $COL_LATITUDE REAL,
                $COL_LONGITUDE REAL
            )
        """
            db?.execSQL(createTableQuery)
        }

        // This is called when the database version is upgraded (e.g., from 1 to 2)
        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            // Drop the old table if it exists
            db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            // Create a new table
            onCre

        }