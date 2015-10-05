package lab3;

import java.util.*;

/**
 * Input reader for Lab 4b airport and flight data
 *
 * To read all the information necessary for this lab:
 *   (1) Create an object (say, "input") of type Input.
 *   (2) Call input.readAirports(<airportFileName>)
 *   (3) Call input.readFlights(<flightFileName>)
 *
 * Note that you *must* do (3) after (2).
 *
 * If all goes well, you will then have access to
 *
 *   * input.airports   -- an array of Airport objects
 *
 *   * input.flights    -- an array of Flight objects
 *
 *   * input.airportMap -- a HashMap mapping airport codes to the
 *                         corresponding Airport objects
 */
class Input {

    /**
     * Airport information
     */
    class Airport {
        // Name of airport (3-letter code)
        public String name;
        // Offset of local time from GMT (in minutes)
        public int offset;
        // Integer identifier for convenience
        public int id;
    }

    /*
     * Flight information
     *
     * NB: all times are GMT, in minutes since midnight
     */
    class Flight {
        // Flight name
        public String name;
        // Flight termini
        public Airport startAirport, endAirport;
        // Departure and arrival times
        public int startTime, endTime;
    }

    // All airports read from input
    public Airport airports[];

    // all flights read from input
    public Flight flights[];

    // Mapping of airport codes to airports
    public HashMap<String, Airport> airportMap;

    /**
     * Creates a new Input.
     */
    public Input() {
        airportMap = new HashMap<String,Airport>();
    }

    /**
     * Read in the airports from the file.
     */
    public void readAirports(String filename) {
        FileParser fp = new FileParser(filename);

        // Hold the airports as they are read
        ArrayList<Airport> aplist = new ArrayList<Airport>();

        while (!fp.isEof()) {
            Airport ap = new Airport();
            ap.name   = fp.readWord();
            ap.offset = (fp.readInt() / 100) * 60;

            if (!fp.isEof()) {
                aplist.add(ap);
            }
        }
        airports = new Airport[aplist.size()];
        for (int j = 0; j < aplist.size(); j++) {
            Airport ap = aplist.get(j);
            airports[j] = ap;
            airportMap.put(ap.name, ap);
        }
    }

    /**
     * Read in the flights from the file.
     */
    public void readFlights(String filename) {
        FileParser fp = new FileParser(filename);

        // Hold the flights as they are read
        ArrayList<Flight> fllist = new ArrayList<Flight>();

        // Read the flights and store their times in GMT
        while (!fp.isEof()) {
            Flight fl = new Flight();
            String airline = fp.readWord();
            int flightno = fp.readInt();
            fl.name = airline + "-" + flightno;
            if (fp.isEof()) {
                break;
            }
            String code = fp.readWord();
            fl.startAirport = airportMap.get(code);
            int tm = fp.readInt();
            String ampm = fp.readWord();
            fl.startTime = toTime(tm, ampm, fl.startAirport.offset);
            code = fp.readWord();
            fl.endAirport = airportMap.get(code);
            tm = fp.readInt();
            ampm = fp.readWord();
            fl.endTime = toTime(tm, ampm, fl.endAirport.offset);
            fllist.add(fl);
        }
        flights = new Flight [fllist.size()];
        flights = fllist.toArray(flights);
    }

    /**
     * Convert raw time value and AM/PM in local time, to minutes since
     * midnight in GMT, using supplied offset from GMT.
     */
    private int toTime(int timeRaw, String ampm, int offset) {
        int hour   = (timeRaw / 100) % 12;
        int minute = timeRaw % 100;
        boolean isPM = (ampm.charAt(0) == 'P');
        int minutes = hour * 60 + minute;
        if (isPM) {
            minutes += 12 * 60;
        }
        int finalTime = (minutes - offset + 24 * 60) % (24 * 60);
        return finalTime;
    }
}
