using System.Data.Entity.ModelConfiguration.Conventions;
using System.Data.Entity;
using Microsoft.EntityFrameworkCore;
using final_asp_project.Models;

namespace final_asp_project.Data
{
    public class ClaimsContext : Microsoft.EntityFrameworkCore.DbContext
    {

        protected readonly IConfiguration Configuration;

        public ClaimsContext(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        protected override void OnConfiguring(DbContextOptionsBuilder options)
        {
            // connect to sql server with connection string from app settings
            options.UseSqlServer("Server=(localdb)\\mssqllocaldb;Database=GuillermoTapia.ConsoleApp.NewDb;Trusted_Connection=True;");
        }


        public Microsoft.EntityFrameworkCore.DbSet<Claim> Claims { get; set; }
        public Microsoft.EntityFrameworkCore.DbSet<Vehicle> Vehicles { get; set; }
        public Microsoft.EntityFrameworkCore.DbSet<Owner> Owners { get; set; }
    }
}
