using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab1cSharp.Domain
{
    public class sarcina:hasId<int>
    {
        
        private string _descriere;
        public string  descriere { get { return _descriere; } set { _descriere = value; } }
        public sarcina()
        {
            _id = -1;
            _descriere = "";
        }

        public sarcina(int id, string desc):base(id)
        {
            _descriere = desc;          
        }

        public override string ToString()
        {
            return base.ToString() + " " + _descriere.PadRight(15);
        }

        public override bool Equals(object obj)
        {
            if (obj == null)
                return false;
            if (!(obj is sarcina))
                return false;
            sarcina aux = (sarcina)obj;
            return _id == aux.id && _descriere ==aux.descriere;
        }

        public string export(string separator)
        {
            return id.ToString() + separator +descriere+separator;
        }

    }

}
