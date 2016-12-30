using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab1cSharp.Domain
{
    public class post:hasId<int>
    {
        private string _denumire;
        private string _tip;
        
        public  string denumire { get { return _denumire; } set { _denumire = value; } }
        public string tip { get { return _tip; } set { _tip = value; } }
        
       

        public post(int id,string denum,string tip):base(id)
        {
            _denumire = denum;
            _tip = tip;
            _id = id;
        }

         public post()
        {
            _denumire = "";
            _tip = "";
            _id = -1;
        }
        public override string ToString()
        {
            return base.ToString() + " " +_tip.PadRight(15)+" "+ _denumire.PadRight(15);
        }

        public override bool Equals(object obj)
        {
            if (obj == null)
                return false;
            if (!(obj is post))
                return false;
            post aux = (post)obj;
            return aux.denumire == _denumire && aux.tip == _tip && _id ==aux.id;
        }

        public string export(string separator){
            return id.ToString() + separator + denumire + separator + tip+separator;
        }
    }
}
