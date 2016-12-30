using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab1cSharp.Domain
{
    public class PostComparer : IComparer<post>
    {
        public int Compare(post x, post y)
        {
            return x.denumire.CompareTo(y.denumire);
        }
    }
}
