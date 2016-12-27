using lab1cSharp.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lab1cSharp.Repository
{
   public interface IRepository<ID,T> where T : hasId<ID>
                                where ID : IComparable<ID>
    {
        void add(T item);
        T delete(ID key);
        void update(ID key, T newItem);
        T findByID(ID key);
        List<T> getAll();
        void sort();

    }
}
