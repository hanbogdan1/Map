using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab1cSharp.Domain
{
    class SarcinaComparer : IComparer<sarcina>
    {
        public int Compare(sarcina x, sarcina y)
        {
            return x.descriere.CompareTo(y.descriere);
        }
    }
}
