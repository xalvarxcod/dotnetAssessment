namespace final_asp_project.Models
{
    public class Owner
    {
        public int OwnerId { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string DriverLicense { get; set; }

        public List<Vehicle> Vehicles { get; set; }
    }
}
