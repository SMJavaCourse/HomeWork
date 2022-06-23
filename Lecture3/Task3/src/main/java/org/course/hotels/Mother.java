package org.course.hotels;


public class Mother {
    private String name = "У Мамы лучше";
    public String[] rooms = new String[]{"  - 1 однокомнатный номер с балконом (цена 1000 р/сутки, вместимость до 2 человек, время заселения 12:00)",
            "  - 1 двухкомнатный номер с балконом, уборкой номера, интернетом и кондиционером (цена 3000 р/сутки, вместимость до 4 человек, время заселения 12:00)",
            "  - 1 двухкомнатный номер с балконом, уборкой номера, интернетом и кондиционером (цена 3000 р/сутки, вместимость до 4 человек, время заселения 12:00)",
            "  - 1 трехкомнатный номер (цена 2500 р/сутки, вместимость до 6 человек, время заселения 12:00)",
            "  - 1 трехкомнатный номер с балконом и интернетом (цена 3500 р/сутки, вместимость до 6 человек, время заселения 12:00)"};
    public void countRooms(){
        int countRooms = rooms.length;
        System.out.println("Количество номеров: " + countRooms + "\n" + "Номера:");
        }

    private String time;

    public Mother(String time){
        this.time = time;
    }

    public String getTime() {
        return time;
    }
    public void soutTime(){
        System.out.println("Время заселения " + getTime());
    }
    public void soutName(){
        System.out.println("Отель \"" + name+ "\"");
    }
    public void soutRooms(){
        for (int i=0;i < rooms.length; ++i){
            System.out.println(rooms[i]);
        }
    }

}
