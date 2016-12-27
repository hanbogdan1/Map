using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab1cSharp.Domain
{
    class FisaPost : hasId<int>
    {
        private post p;
        private sarcina s;
        public FisaPost(post Post, sarcina Sarcina) : base() {
            p = Post;
            s = Sarcina;
        }


        public post Post { get { return p; } set { p = value; } }
        public sarcina Sarcina { get { return s; } set { s = value; } }

        public override string ToString()
        {
            return p.ToString() + s.ToString();
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
            return p.export(separator) + s.export(separator);
        }
    }
}
