﻿using lab1cSharp.Controller;
using lab1cSharp.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace lab1cSharp.UserInterface
{
   public class Ui
    {
        private ControllerFinal ctrl;
        public Ui(ControllerFinal Controller)
        {
            ctrl = Controller;
        }



        void afisare_meniu()
        {
            Console.WriteLine("Alegeti o optiune din meniu ! ");
            Console.WriteLine("1 -Adaugare sarcina.");
            Console.WriteLine("2 -Stergere sarcina.");
            Console.WriteLine("3 -Modificare sarcina.");
            Console.WriteLine("4 -Adaugare post.");
            Console.WriteLine("5 -Stergere post.");
            Console.WriteLine("6 -Modificare post.");
            Console.WriteLine("7 -Adaugare fisa de post.");
            Console.WriteLine("8 -Stergere fisa de post.");
            Console.WriteLine("9 -Modificare fisa de post.");
            Console.WriteLine("10-Afisare posturi.");
            Console.WriteLine("11-Afisare sarcini.");
            Console.WriteLine("12-Afisare fise de posturi.");
            Console.WriteLine("13-Filtrare post tip.");
            Console.WriteLine("14-Filtrare post denumire.");
            Console.WriteLine("15-Filtrare sarcina descriere.");
            Console.WriteLine("16-Sortare posturi.");
            Console.WriteLine("17-Sortare sarcini.");
            Console.WriteLine("0-EXIT!");
            Console.WriteLine("\n \n ");       
        }

        public void start()
        {
            int comanda =-1;
            while (comanda != 0) {
                afisare_meniu();
                comanda=read_int("introduceti comanda!");
                try
                {
                    switch (comanda)
                    {

                        case 1:
                            adaugare_sarcina();
                            break;
                        case 2:
                            stergere_sarcina();
                            break;
                        case 3:
                            update_sarcina();
                            break;
                        case 4:
                            adaugare_post();
                            break;
                        case 5:
                            stergere_post();
                            break;
                        case 6:
                            update_post();
                            break;
                        case 7:
                            adaugare_fisa();
                            break;
                        case 8:
                            stergere_fisa();
                            break;
                        case 9:
                            update_fisa();
                            break;
                        case 10:
                            afisare_posturi();
                            break;
                        case 11:
                            afisare_sarcini();
                            break;
                        case 12:
                            afisare_fise();
                            break;
                        case 13:
                            filter_post_tip();
                            break;
                        case 14:
                            filter_post_denumire();
                            break;
                        case 15:
                            filter_sarcini();

                            break;

                        case 16:
                            sort_post();
                            break;

                        case 17:
                            sort_sarcini();
                            break;

                        case 0:
                            Console.WriteLine("Exit!");
                            break;
                        default:
                            Console.WriteLine("Introduceti o valoare valida !");
                            break;

                    }
                }
                catch (MyException e)
                {
                    Console.WriteLine(e.Message);
                }
            }

        }


        int read_int(string message)
        {
            Console.WriteLine(message);
            int comanda;
            string input;
            input = Console.ReadLine();
            while (!Int32.TryParse(input, out comanda)) 
            {
                Console.WriteLine("Introduceti o valoare valida !");
                input = Console.ReadLine();

            }
            return comanda;
            
        }



        string read_string(string message)        {
            Console.WriteLine(message);
            string input;
            input = Console.ReadLine();
            return input;
        }


        void adaugare_sarcina()        {

            ctrl.add_sarcina(read_int("Introduceti id!"),read_string("Introduceti descriere!"));

        }

        void stergere_sarcina()        {
            ctrl.delete_sarcina(read_int("Introduceti id!"));
        }

        void update_sarcina()        {
            ctrl.update_sarcina(read_int("Introduceti id!"), read_string("Introduceti descriere!"));
        }
        
        void adaugare_post()
        {
            ctrl.add_post(read_int("Introduceti id!"),read_string("Introduceti denumire!"), read_string("Introduceti tip!"));
        }
        void update_post()
        {
            ctrl.update_post(read_int("Introduceti id!"), read_string("Introduceti denumire!"), read_string("Introduceti tip!"));
        }
        void stergere_post()
        {
            ctrl.delete_post(read_int("Introduceti id !"));
        }
        void adaugare_fisa()
        {
            ctrl.add_fisa(read_int("Introduceti id fisa!"), read_int("Introduceti id post!"), read_int("Introduceti id sarcina !"));
        }

        void update_fisa()
        {
            ctrl.update_fisa(read_int("Introduceti id !"), read_int("Introduceti id post!"), read_int("Introduceti id sarcina !"));
        }
        void stergere_fisa()
        {
            ctrl.delete_fisa(read_int("Introduceti id !"));
        }

        void afisare_posturi()
        {
            ctrl.afisare_posturi();
        }
        void afisare_sarcini()
        {
            ctrl.afisare_sarcina();
        }
        void afisare_fise()
        {
            ctrl.afisare_fisa();
        }


        void filter_post_tip()
        {
            string a;
            a = read_string("Introduceti tipul job-ului (part/fulltime)");
            ctrl.filtrare_posturi(x => x.tip.Equals(a));
        }
        void filter_post_denumire()
        {
            string a = read_string("Introduceti denumire pt filtrare !");
            ctrl.filtrare_posturi(x => x.denumire.Contains(a));
        }

        void filter_sarcini()
        {
            string a = read_string("Introduceti descriere pt filtrare !");
            ctrl.filtrare_sarcini(x => x.descriere.Contains(a));

        }

        void sort_post()
        {
            ctrl.sortare_posturi(new PostComparer());
        }
        void sort_sarcini()
        {
            ctrl.sortare_sarcini(new SarcinaComparer());
            
        }
    }
}
