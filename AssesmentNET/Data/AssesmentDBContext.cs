using AssesmentNET.Models;
using Microsoft.EntityFrameworkCore;



namespace AssesmentNET.Data
{
    public class AssesmentDBContext : DbContext
    {
        public AssesmentDBContext()
        {

        }

        public AssesmentDBContext(DbContextOptions<AssesmentDBContext> options)
            : base(options)
        {

        }

        // DbSet's here
        public DbSet<Claims> Claims { get; set; }
        public DbSet<Vehicles> Vehicles { get; set; }
        public DbSet<Owners> Owners { get; set; }



        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {

            IConfiguration configuration = new ConfigurationBuilder().AddJsonFile("appsettings.json").Build();

            optionsBuilder.UseSqlServer(configuration.GetConnectionString("DefaultConnection"));
        }

    }
}
