using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab1cSharp.Domain
{
    class ValidatorSarcina : validator<sarcina>
    {
        public void validate(sarcina obj)
        {
            string Erori = "";
            if (obj.descriere == "")
                Erori += "Trebuie sa introduceti descriere ! \n";
            if (obj.id < 0)
                Erori += "id trebuie sa fie >= 0";
            if (Erori != "")
                throw new MyException(Erori);
            
        }
    }
}
