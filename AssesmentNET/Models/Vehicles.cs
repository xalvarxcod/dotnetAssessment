namespace AssesmentNET.Models
{
    public class Vehicles
    {
        public int Id { get; set; }
        public string Brand { get; set; }
        public string Vin { get; set; }
        public string Color { get; set; }
        public string Year { get; set; }
        public Owners Owner_Id { get; set; }

    }
}
