using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using lab1cSharp.Domain;

namespace lab1cSharp.Repository
{
    public abstract class AbstractRepository<ID,T> : IRepository<ID, T> where T : hasId<ID>
                                                                  where ID : IComparable<ID>
    {
        private List<T> items;
        public AbstractRepository()
        {
            items = new List<T>();
        }
        public void add(T item)
        {
            if (findByID(item.id) == null)
                items.Add(item);
            else
                throw new MyException("Exista deja un element cu id " + item.id.ToString() + " in lista ! ");
        }

        public T delete(ID key)
        {
            T element = findByID(key);
            if (element != null)
            {
                items.Remove(element);
                return element;
            }
            else
                throw new MyException("Nu exista un element cu id " + key.ToString() + " in lista ! ");
        }

        public T findByID(ID key)
        {
            int index = items.FindIndex((x) => x.id.Equals(key));
            if (index != -1)
            {
                return items.ElementAt(index);
            }
            else
            {
                return default(T);
            }
        }

        public List<T> getAll()
        {
            return items;
        }

        
        public void update(ID key, T newItem)
        {
            delete(key);
            add(newItem);

        }

        public abstract void WriteToFile();
        public abstract void LoadFromFile();
        public abstract void sort();
    }
}
