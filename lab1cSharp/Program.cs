using lab1cSharp.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using lab1cSharp.Controller;
using lab1cSharp.Repository;
using lab1cSharp.UserInterface;

namespace lab1cSharp
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                PostRepository PostRep = new PostRepository(@"C:\Users\Bogdan\Documents\Visual Studio 2015\Projects\lab1cSharp\lab1cSharp\Data\Post.txt");
                SarcinaRepository SarcinaRep = new SarcinaRepository(@"C:\Users\Bogdan\Documents\Visual Studio 2015\Projects\lab1cSharp\lab1cSharp\Data\Sarcina.txt");
                FisaRepository FisaRep = new FisaRepository(@"C:\Users\Bogdan\Documents\Visual Studio 2015\Projects\lab1cSharp\lab1cSharp\Data\Fisa.txt");
                ControllerFinal ctrl = new ControllerFinal(PostRep, SarcinaRep, FisaRep);
                Ui UserInterf = new Ui(ctrl);
                UserInterf.start();
            }
            catch (MyException e)
            {
                Console.WriteLine(e.Message);
            }
          
        }
    }

}
