using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using AssesmentNET.Models;

namespace AssesmentNET.Controllers
{
    public class VehiclesController : Controller
    {

        private IList<Vehicles> vehiclesList = new List<Vehicles>
        {new Vehicles() {Id = 1, Brand= "Audi", Color="White", Vin = "12345678", Year = "1999" },
            new Vehicles() {Id = 2, Brand= "Mercedes", Color="Red", Vin = "1234567", Year = "2000" },
            new Vehicles() {Id = 3, Brand= "BMW", Color="Yellow", Vin = "123456", Year = "2001" },
            new Vehicles() {Id = 4, Brand= "Seat", Color="Blue", Vin = "12345", Year = "2002" },
            new Vehicles() {Id = 5, Brand= "KIA", Color="Green", Vin = "1234", Year = "2003" },
            new Vehicles() {Id = 6, Brand= "Skoda", Color="Black", Vin = "123", Year = "2004" },
            };

            // GET: VehiclesController
        public ActionResult Index()
        {
            return View(vehiclesList.OrderBy(v => v.Id).ToList());
        }

        // GET: VehiclesController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: VehiclesController/Create
        public ActionResult Create()
        {
            var vehicleNew = new Vehicles();
            return View(vehicleNew);
        }
        public ActionResult CreateVehicle(Vehicles vehicle)
        {
            vehiclesList.Add(vehicle);
            return RedirectToAction(nameof(Index));
        }

        

        // GET: VehiclesController/Edit/5
        public ActionResult Edit(int id)
        {
            var veh = vehiclesList.Where(v => v.Id == id).FirstOrDefault();
            return View(veh);
        }

        // POST: VehiclesController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: VehiclesController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: VehiclesController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
