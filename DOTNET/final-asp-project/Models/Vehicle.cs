namespace final_asp_project.Models
{
    public class Vehicle
    {
        public int VehicleId { get; set; }
        public string Brand { get; set; }
        public string Vin { get; set; }
        public string Color { get; set; }
        public int Year { get; set; }
        public int OwnerId { get; set; }
        public Owner Owner { get; set; }
        public List<Claim> Claims { get; set; }
    }
}