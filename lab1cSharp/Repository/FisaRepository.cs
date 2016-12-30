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
     
       public FisaRepository(string fnamee):base(fnamee)
        {
           
        }

        public override void LoadFromFile()
        {
            StreamReader sr = new StreamReader(fname);
            while (!sr.EndOfStream)
            {                               
                String line = sr.ReadLine();
                String[] toke = line.Split(',');
                if (toke.Length != 7)
                    throw new MyException("Fisier corupt!");
                int id = int.Parse(toke[0]);
                post p = new post(int.Parse(toke[1]), toke[2], toke[3]);
                sarcina z = new sarcina(int.Parse(toke[4]), toke[5]);
                items.Add(new FisaPost(id,p,z));
                

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


        public void delete_by_post_id(int id)
        {
            foreach( FisaPost f in items)
            {
                if (f.Post.id == id)
                    items.Remove(f);
            }
        }

        public void delete_by_sarcina_id(int id)
        {
            foreach (FisaPost f in items)
            {
                if (f.Sarcina.id == id)
                {
                    items.Remove(f);
                    WriteToFile();
                }
            }
        }


        public void update_by_post(int id, string denumire, string tip)
        {
            foreach (FisaPost f in items)
            {
                if (f.Post.id == id)
                {
                    f.Post.denumire = denumire;
                    f.Post.tip = tip;
                    WriteToFile();
                }                
                    
            }
        }

        public void update_by_sarcina(int id,string descriere)
        {
            foreach (FisaPost f in items)
            {
                if (f.Sarcina.id == id)
                {
                    f.Sarcina.descriere = descriere;
                    WriteToFile();
                }
                    
            }
        }



    }
}
