using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using lab1cSharp.Domain;

namespace lab1cSharp.Repository
{
    public class FisaPostRepository
    {
        private Dictionary<post, List<sarcina>> FisaPost;

        FisaPostRepository()
        {
             FisaPost = new Dictionary<post, List<sarcina>>();
        }


        void add (post P,sarcina S)
        {
            List<sarcina> lst;
            if (FisaPost.TryGetValue(P, out lst))
                lst.Add(S);
            else
            {
                lst = new List<sarcina>();
                lst.Add(S);
                FisaPost[P] = lst;
            }
        }


        void remove(post P, sarcina S)
        {
            if (!FisaPost.ContainsKey(P))
                throw new MyException("Nu exista nici o sarcina asociata postului cu id " + P.id.ToString());
            else
            {
                List<sarcina> lst;
                FisaPost.TryGetValue(P, out lst);
                lst.Remove(S);
            }
        }
        void remove(post P)
        {
            if (!FisaPost.ContainsKey(P))
                throw new MyException("Nu exista nici o sarcina asociata postului cu id " + P.id.ToString());
            else
                FisaPost.Remove(P);
        }


   
        void afisare_fisa_post()
        {
            foreach( post p in FisaPost.Keys)
            {
                Console.WriteLine("\n \n ");
                Console.WriteLine("Postul :");
                Console.WriteLine(p.ToString());
                Console.WriteLine("Sarcini :");
                foreach (sarcina b in FisaPost[p])
                {
                    Console.WriteLine(b.ToString());
                }
            }
        }

    }
}
