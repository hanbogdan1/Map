using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SQLite;
using System.Data.SqlClient;

namespace ConenctionUtills
{
    class SqliteConnectionFactory:ConnectionFactory
    {

        public override IDbConnection createConnection()
        {           
            String connectionString = "Data Source=database.db;Version=3.1.1";
            return new SQLiteConnection(connectionString);           
        }
    }
}
