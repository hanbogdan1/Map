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
            PostRepository PostRep = new PostRepository(@"..\..\Data\Post.txt");
            SarcinaRepository SarcinaRep = new SarcinaRepository(@"..\..\Data\Sarcina.txt");
            FisaRepository FisaRep = new FisaRepository(@"..\..\Data\Fisa.txt");
            ControllerFinal ctrl = new ControllerFinal(PostRep, SarcinaRep, FisaRep);
            Ui UserInterf = new Ui(ctrl);
            UserInterf.start();
        }
    }

}
