using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Data.Entity.Validation;

namespace AmebaDevice.DAL
{
    public class ModelloDatiDbContext : DbContext
    {
        
        public ModelloDatiDbContext() : base("ModelContainer")
        {

        }

        public DbSet<Customer> Customers { get; set; }
        public DbSet<Building> Buildings { get; set; }
        public DbSet<Floor> Floors { get; set; }
   

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();

            modelBuilder.Entity<Building>()
                .HasOptional<Customer>(c => c.Customer)
                .WithMany()
                .WillCascadeOnDelete(false);
            
        }


        



    }
}