package org.course.hotels;


public class Grill {
    private String name = "Шашлычок";
    private String[] rooms = new String[]{"    - 1 однокомнатный номер с шашлычком в номер (цена 1000 р/сутки, вместимость до 2 человек, время заселения 09:00)",
            "    - 1 двухкомнатный номер с балконом и уборкой номера (цена 2000 р/сутки, вместимость до 4 человек, время заселения 09:00)",
            "    - 1 трехкомнатный номер с уборкой номера (цена 4000 р/сутки, вместимость до 6 человек, время заселения 09:00)"};
    public void countRooms(){
        int countRooms = rooms.length;
        System.out.println("Количество номеров: " + countRooms + "\n" + "Номера:");
    }
    private String time;
    public Grill (String time){
        this.time = time;
    }

    public String getTime() {
        return time;
    }
    public void soutTime(){
        System.out.println("Время заселения " + getTime());
    }
    public void soutName() {
        System.out.println("Отель \"" + name +"\"");
    }
    public void soutRooms(){
        for (int i=0;i < rooms.length; ++i){
            System.out.println(rooms[i]);
        }
    }
}
