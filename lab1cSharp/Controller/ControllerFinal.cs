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

        public void add_post(int id,string denumire,string tip)
        {
            post p = new post(id, denumire, tip);
            postVal.validate(p);
            PostRepo.add(p);
            
        }


        public void update_post(int id, string denumire, string tip)
        {
            post p = new post(id, denumire, tip);
            postVal.validate(p);
            PostRepo.update(id, p);
            FisaRepo.update_by_post(id, denumire, tip);

        }

        public void delete_post(int id)
        {
            PostRepo.delete(id);
            FisaRepo.delete_by_post_id(id);
        }

        public void afisare_posturi_list(List<post> list)
        {
            Console.WriteLine("******************************** \n");
            Console.WriteLine("Id".PadRight(5)+ " "+ "Denumire".PadRight(15)+ " "+ "Tip".PadRight(15) + "\n") ;
            foreach (post t in list)
            {
                Console.WriteLine(t.ToString());
            }
            Console.WriteLine("******************************** \n");
        }


        public void afisare_posturi()
        {
            afisare_posturi_list(PostRepo.getAll());
        }

        public void add_sarcina(int id, string descriere)
        {
            sarcina p = new sarcina(id,descriere);
            sarcinaVal.validate(p);
            SarcinaRepo.add(p);
        }


        public void update_sarcina(int id, string descriere)
        {
            sarcina p = new sarcina(id, descriere);
            sarcinaVal.validate(p);
            SarcinaRepo.update(id,p);
            FisaRepo.update_by_sarcina(id, descriere);
        }

        public void delete_sarcina(int id)
        {
            SarcinaRepo.delete(id);
            FisaRepo.delete_by_sarcina_id(id);
        }

        public void afisare_sarcina_list(List<sarcina>lst)
        {
            Console.WriteLine("******************************** \n");
            Console.WriteLine("Id".PadRight(5)+" "+"Descriere".PadRight(15) + "\n");
            foreach (sarcina t in lst)
            {
                Console.WriteLine(t.ToString());
            }

            Console.WriteLine("******************************** \n");


        }


       public void afisare_sarcina()
        {
            afisare_sarcina_list(SarcinaRepo.getAll());
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
            Console.WriteLine("******************************** \n");
            Console.WriteLine("Id".PadRight(5)+" " +"Id p".PadRight(5)+" "+"Tip".PadRight(15)+ " "+"Denumire".PadRight(15) +"Id s".PadRight(5)+ "Descriere".PadRight(15) + "\n");
            foreach (FisaPost t in FisaRepo.getAll())
            {
                Console.WriteLine(t.ToString());
            }
            Console.WriteLine("******************************** \n");
        }



        public void filtrare_posturi(Predicate<post> filter)
        {
            afisare_posturi_list(PostRepo.getAll().Where(x => filter(x)).ToList());
        }


        public void filtrare_sarcini(Predicate<sarcina> filter)
        {
            afisare_sarcina_list(SarcinaRepo.getAll().Where(x => filter(x)).ToList());
        }

        public void sortare_posturi( IComparer<post> cmp)
        {
            PostRepo.getAll().Sort(cmp);
            afisare_posturi_list(PostRepo.getAll());
        }

        public void sortare_sarcini(IComparer<sarcina> cmp)
        {
            SarcinaRepo.getAll().Sort(cmp);
            afisare_sarcina();
        }

    }


}
