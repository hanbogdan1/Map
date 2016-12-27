using lab1cSharp.Domain;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab1cSharp.Repository
{
    public class PostRepository : AbstractRepository<int, post>
    {
        private String fname;

        PostRepository(string fnamee):base()
        {
            fname = fnamee;
            LoadFromFile();
        }

        public override void LoadFromFile()
        {
            StreamReader sr = new StreamReader(fname);
            while (!sr.EndOfStream)
            {
                String line = sr.ReadLine();
                String[] toke = line.Split(',');
                if (toke.Length == 3)
                {
                    post p = new post(int.Parse(toke[0]), toke[1], toke[2]);
                    add(p);
                }

            }
            sr.Close();
        }

        public override void sort()
        {
            throw new NotImplementedException();
        }

        public override void WriteToFile()
        {
            StreamWriter sr = new StreamWriter(fname);
            foreach (post p in getAll())
            {
                sr.WriteLine(p.export(","));
            }

            sr.Close();
        }
    }
}
