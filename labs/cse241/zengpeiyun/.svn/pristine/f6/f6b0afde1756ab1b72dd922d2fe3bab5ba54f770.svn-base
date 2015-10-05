package lab3;

/**
 * Driver for airline scheduling shortest-paths code
 */
class Lab3b {

    public static void main(String args[]) {
        if (args.length < 3) {
            System.err.println("Syntax: Lab3b <transcript> <airports> <flights>");
            return;
        }

        Terminal.startTranscript(args[0]);

        // Read the input
        Input input = new Input();
        input.readAirports(args[1]);
        System.out.println("Read " + input.airports.length + " airports");
        input.readFlights(args[2]);
        System.out.println("Read " + input.flights.length + " flights");


        Multigraph G = new Multigraph();

        // Allocate a vertex for every airport.  Logically, the jth 
        // vertex corresponds to the jth entry in input.airports[].
        for (int j = 0; j < input.airports.length; j++) {
            input.airports[j].id = j;
            Vertex v = new Vertex(j);
            G.addVertex(v);
        }

        // While we allocate all the edges, set the id for each
        // edge to the index of the corresponding flight in the
        // input.flights[] array.
        for (int k = 0; k < input.flights.length; k++) {
            Input.Flight fl = input.flights[k];

            Vertex from = G.get(fl.startAirport.id);
            Vertex to   = G.get(fl.endAirport.id);

            int len = fl.endTime - fl.startTime;
            if (len < 0) {
                len += 24 * 60; // next day
            }

            Edge e = new Edge(k, from, to, len);
            from.addEdge(e);
         }

        // Do the shortest-paths computation
        findPaths(input, G);
    }


    /**
     * Construct shortest paths from a specified starting
     * airport to every vertex of G, and then answer queries
     * asking for the shortest path (least total travel time)
     * from the start to other airports.
     */
    private static void findPaths(Input input, Multigraph G) {
        // Fix the starting airport

        Terminal.print("Starting airport? ");
        String start = Terminal.readWord();
        Input.Airport ap = null;
        
        if (start != null) {
            ap = input.airportMap.get(start.toUpperCase());
        }
        if (ap == null) {
            System.err.println("Error: airport code " + start + " is unknown");
            return;
        }

        // YOUR CODE CALLED HERE -- find shortest paths from start.
        ShortestPaths sp = new ShortestPaths(G, ap.id);

        // Field shortest-path queries to other airports
        while (true) {
            Terminal.print("Ending airport? ");
            String end = Terminal.readWord();
            Input.Airport eap = null;

            if (end != null) {
                eap = input.airportMap.get(end.toUpperCase());
            } else if (eap == ap) {
                System.out.println("You're already there!");
                continue;
            } else {
                System.err.println("Error: airport code " + end +
                    " is unknown");
                continue;
            }

            int flightIds[] = sp.returnPath(eap.id);
            if (flightIds.length == 0) {
                Terminal.println("No path to " + end);
            } else {
                printPath(input, flightIds);
            }
        }
    }

    /**
     * Print a path of edges (flight identifiers) between airports
     */
    private static void printPath(Input input, int flightIds[]) {
        Terminal.println(input.flights[flightIds[0]].startAirport.name);

        for (int j = 0; j < flightIds.length; j++) {
            Input.Flight fl = input.flights[flightIds[j]];

            Terminal.println("---> " + fl.endAirport.name + " (" + fl.name +
                ", " + prettyTime(fl.startTime, fl.endTime) + ")");
        }
    }

    /**
     * Pretty-print an elapsed time interval.
     *
     * Input times are in minutes since midnight.
     */
    private static String prettyTime(int startTime, int endTime) {
        int len = endTime - startTime;
        if (len < 0) {
            len += 24 * 60;
        }
        
        int hours = len / 60;
        int minutes = len % 60;
        
        String hourstring, minutestring;
        if (hours > 0) {
            hourstring = hours + " hours";
        } else {
            hourstring = "";
        }
        
        if (minutes > 0) {
            minutestring = minutes + " minutes";
        } else {
            minutestring = "";
        }
        
        if (hours > 0 && minutes > 0) {
            return hourstring + ", " + minutestring;
        } else {
            return hourstring + minutestring;
        }
    }
}
