using System;
using lab1cSharp.Repository;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using lab1cSharp.Domain;

namespace lab1cSharp.Controller
{
    public class ControllerFinal
    {
        private PostRepository PostRepo;
        private SarcinaRepository SarcinaRepo;
        private FisaRepository FisaRepo;
        private ValidatorPost postVal;
        private ValidatorSarcina sarcinaVal;

        public ControllerFinal(PostRepository PostRep,SarcinaRepository SarcinaRep,FisaRepository FisaRep)
        {
            PostRepo = PostRep;
            SarcinaRepo = SarcinaRep;
            FisaRepo = FisaRep;
            postVal = new ValidatorPost();
            sarcinaVal = new ValidatorSarcina();
        }

        public void add_post(string denumire,string tip, int id)
        {
            post p = new post(id, denumire, tip);
            postVal.validate(p);
            PostRepo.add(p);
        }


        public void update_post(string denumire, string tip, int id)
        {
            post p = new post(id, denumire, tip);
            postVal.validate(p);
            PostRepo.update(id, p);
        }

        public void delete_post(int id)
        {
            PostRepo.delete(id);
        }

        public void afisare_posturi()
        {
            foreach(post t in PostRepo.getAll())
            {
                Console.WriteLine(t.ToString());
            }
        }




        public void add_sarcina(string descriere, int id)
        {
            sarcina p = new sarcina(id,descriere);
            sarcinaVal.validate(p);
            SarcinaRepo.add(p);
        }


        public void update_sarcina(string descriere,  int id)
        {
            sarcina p = new sarcina(id, descriere);
            sarcinaVal.validate(p);
            SarcinaRepo.update(id,p);
        }

        public void delete_sarcina(int id)
        {
            SarcinaRepo.delete(id);
        }

        public void afisare_sarcina()
        {
            foreach (sarcina t in SarcinaRepo.getAll())
            {
                Console.WriteLine(t.ToString());
            }
        }





        public void add_fisa(int id,int id_post, int id_sarcina)
        {
            post p = PostRepo.getAll().Find(new Predicate<post>(  aa => aa.id == id_post));
            if (p == null)
                throw new MyException("Post cu id introdus nu exista !");
            sarcina x = SarcinaRepo.getAll().Find((xx) => xx.id == id_sarcina);
            if  (x== null)
                throw new MyException("Sarcina cu id introdus nu exista !");

            FisaRepo.add(new FisaPost(id,p, x));

        }
        public void delete_fisa(int id)
        {
            FisaRepo.delete(id);
            
        }

        public void update_fisa(int id, int id_s,int id_p)
        {
            post p = PostRepo.getAll().Find(new Predicate<post>(aa => aa.id == id_p));
            if (p == null)
                throw new MyException("Post cu id introdus nu exista !");
            sarcina x = SarcinaRepo.getAll().Find((xx) => xx.id == id_s);
            if (x == null)
                throw new MyException("Sarcina cu id introdus nu exista !");
            FisaRepo.delete(id);
            FisaRepo.add(new FisaPost(id, p, x));
        }

        public void afisare_fisa()
        {
            foreach (FisaPost t in FisaRepo.getAll())
            {
                Console.WriteLine(t.ToString());
            }
        }
    }


}
