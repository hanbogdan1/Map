using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab1cSharp.Domain
{
   public class FisaPost : hasId<int>
    {
        private post p;
        private sarcina s;
        public FisaPost(int Id,post Post, sarcina Sarcina) : base() {
            p = Post;
            id = Id;
            s = Sarcina;
        }


        public post Post { get { return p; } set { p = value; } }
        public sarcina Sarcina { get { return s; } set { s = value; } }

        public override string ToString()
        {
            return id.ToString().PadRight(5)+" " +p.ToString() + s.ToString();
        }



        public override bool Equals(object obj)
        {
            if (obj == null)
                return false;
            if (!(obj is FisaPost))
                return false;

            FisaPost aux = (FisaPost)obj;
            return p.Equals(aux.Post) && s.Equals(aux.Sarcina);

        }

        public string export(string separator)
        {
            return id.ToString()+separator+  p.export(separator)+s.export(separator);
        }
    }
}
