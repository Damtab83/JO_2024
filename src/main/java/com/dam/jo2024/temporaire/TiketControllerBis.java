//package com.dam.jo2024.temporaire;
//
//@RestController
//@RequestMapping(ApiRegistration.REST_API + ApiRegistration.REST_TICKET)
//public class TiketControllerBis {
//
//
//
//        @Autowired
//        private TicketService ticketService;
//        @GetMapping
//        public ResponseEntity<Object> getAllTicket() {
//            List<Ticket> tickets = ticketService.getAllTickets();
//            return ResponseEntity.status(HttpStatus.OK).body(tickets);
//        }
//
//        @GetMapping("{id}")
//        public ResponseEntity<Object> getTicketById(@PathVariable Long id) {
//            Ticket myTicket = ticketService.getTicketById(id);
//            return myTicket == null
//                    ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
//                    : ResponseEntity.status(HttpStatus.OK).body(myTicket);
//        }

//        // ✅ Récupérer les tickets par compte client (id d’utilisateur)
//        @GetMapping("/user/{userId}")
//        public ResponseEntity<Object> getTicketsByUser(@PathVariable Long userId) {
//            List<Ticket> tickets = ticketService.getTicketsByUser(userId);
//            if (tickets == null || tickets.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//            }
//            return ResponseEntity.status(HttpStatus.OK).body(tickets);
//        }

//        @PostMapping
//        public ResponseEntity<Object> createTicket(@RequestBody Ticket myTicket) {
//            ticketService.createTicket(myTicket);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        }

//        @DeleteMapping("{id}")
//        public ResponseEntity<Object> deleteTicket(@PathVariable Long id) {
//            Boolean isDelete = ticketService.deleteTicket(id);
//            return isDelete
//                    ? ResponseEntity.status(HttpStatus.OK).build()
//                    : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//}
