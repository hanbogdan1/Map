using lab1cSharp.Domain;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
    
namespace lab1cSharp.Repository
{
    public class FisaRepository : AbstractRepository<int, FisaPost>
    {
        private String fname;
        FisaRepository(string fnamee):base()
        {
            fname = fnamee;
            LoadFromFile();
        }

        public override void LoadFromFile()
        {
            StreamReader sr = new StreamReader(fname);
            while (!sr.EndOfStream)
            {
                if (File.ReadLines(@"..\..\Data\Fisa.txt").Count() % 2 == 1)
                    throw new MyException("FIsier corupt ! ");
               
                String line = sr.ReadLine();
                String[] toke = line.Split(',');
                if (toke.Length != 3)
                    throw new MyException("Fisier corupt!");
                int id = int.Parse(toke[0]);
                post p = new post(int.Parse(toke[1]), toke[2], toke[3]);

                if (toke.Length != 2)
                    throw new MyException("Fisier corupt!");
                
                sarcina z = new sarcina(int.Parse(toke[0]), toke[1]);
                    add(new FisaPost(id,p,z));
                

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
            foreach (FisaPost p in getAll())
            {
                sr.WriteLine(p.export(","));
            }

            sr.Close();
        }

    }
}
