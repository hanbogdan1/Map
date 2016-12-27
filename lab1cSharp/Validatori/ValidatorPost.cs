using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab1cSharp.Domain
{
    class ValidatorPost : validator<post>
    {
        public void validate(post obj)
        {
            string Erori = "";
            if (obj.denumire == "")
                Erori += "Trebuie adaugata descriere la post ! \n";
            if (obj.tip != "fulltime" && obj.tip != "parttime")
                Erori += "Tipul trebuie sa fie fulltime sau parttime ! \n";
            if (obj.id < 0)
                Erori += "id trebuie sa fie >= 0";
            if (Erori != "")
                throw new MyException (Erori );
        }

    }
}
