package comp2102_project_q2;

import java.util.Random;

public class DoubleLinkedList {

    Student firstStudent;
    Student lastStudent;
    int sizeOfLinkedList = 0;

    public DoubleLinkedList() {
        this.firstStudent = null;
        this.lastStudent = null;
    }

    public void addStudent(String studentName) {

        Student newStudent = new Student(studentName);

        if (firstStudent == null) {
            firstStudent = newStudent;
            lastStudent = newStudent;
            sizeOfLinkedList++;

        } else {
            lastStudent.nextStudent = newStudent;
            newStudent.previousStudent = lastStudent;
            lastStudent = newStudent;
            sizeOfLinkedList++;
        }
    }

    public void determineHub(int numOfHub) {
        Student tempSstudent = firstStudent;
        Random rnd = new Random();
        int counter = 1;

        while (true) {
            int rand = rnd.nextInt(2) + 1;
            if (rand % 2 == 0 && counter <= numOfHub) {
                if (tempSstudent.hub) {
                    tempSstudent = tempSstudent.nextStudent;
                    continue;
                }
                tempSstudent.hub = true;
                counter++;
                tempSstudent = tempSstudent.nextStudent;
                continue;
            }
            if (counter > numOfHub) {
                break;
            }
            tempSstudent = tempSstudent.nextStudent;

        }

    }

    public void display() {

        Student tempStudent = firstStudent;

        for (int i = 0; i < sizeOfLinkedList; i++) {

            if (tempStudent == firstStudent) {
                if (tempStudent.hub) {
                    System.out.print(tempStudent + "*" + " <-> ");
                    tempStudent = tempStudent.nextStudent;
                    continue;
                } else {
                    System.out.print(tempStudent + " <-> ");
                    tempStudent = tempStudent.nextStudent;
                    continue;
                }

            }
            if (tempStudent == lastStudent) {
                if (tempStudent.hub) {
                    System.out.println(tempStudent + "*");
                    tempStudent = tempStudent.nextStudent;
                    break;
                } else {
                    System.out.println(tempStudent);
                    break;
                }

            }
            if (tempStudent.hub && tempStudent != firstStudent && tempStudent != lastStudent) {
                System.out.print(tempStudent + "*" + " <-> ");
                tempStudent = tempStudent.nextStudent;
                continue;
            }
            System.out.print(tempStudent + " <-> ");

            tempStudent = tempStudent.nextStudent;
        }

    }

    public void messageLine(String message, String source, int k) {
        Random rnd = new Random();
        int rand = rnd.nextInt(2) + 1;
        int kk = k;
        Student tempStudent = firstStudent;
        while (true) {
            if (tempStudent.studentName.equals(source)) {
                if (rand % 2 == 0) {
                    System.out.print(tempStudent + " passes message " + message + " in forward direction: ");
                    while (true) {
                        tempStudent = tempStudent.nextStudent;
                        System.out.print(tempStudent + ", ");
                        k--;
                        if (k == 0) {
                            break;

                        }
                    }
                    break;
                } else {
                    System.out.print(tempStudent + " passes message " + message + " in BACK forward direction: ");
                    while (true) {
                        tempStudent = tempStudent.previousStudent;
                        System.out.print(tempStudent + ", ");
                        k--;
                        if (k == 0) {
                            break;
                        }
                    }
                    break;
                }

            } else {
                tempStudent = tempStudent.nextStudent;
            }
        }

    }

    public void messageLinee(String message, String sourceSt, int k) { // k. öğrenci eğer hub ise mesaj iletimini devam ettirtmeye çalışıldı, ancak başaramadık. Yukarıdaki messageLine methodunu kullanılıyor o yüzden...
        Random rnd = new Random();
        int rand = rnd.nextInt(2) + 1;
        int kk = k;
        Student tempStudent = firstStudent;
        while (true) {
            if (tempStudent.studentName.equals(sourceSt)) {
                if (rand % 2 == 0) {
                    System.out.print(tempStudent + " passes message " + message + " in forward direction: ");
                    while (true) {
                        tempStudent = tempStudent.nextStudent;
                        System.out.print(tempStudent + ", ");
                        k--;
                        if (k == 0) {
                            while (true) {
                                if (tempStudent.hub == true) {
                                    tempStudent = tempStudent.nextStudent;
                                    for (k = kk; k == 0; k--) {
                                        System.out.print(tempStudent + ", ");
                                        tempStudent = tempStudent.nextStudent;
                                        if (tempStudent == firstStudent || tempStudent == lastStudent) {
                                            System.exit(0);
                                        }
                                    }

                                } else {
                                    break;
                                }
                            }

                            System.out.println("The message line has ended...");
                            break;

                        }
                    }
                    break;
                } else {
                    System.out.print(tempStudent + " passes message " + message + " in BACK forward direction: ");
                    while (true) {
                        tempStudent = tempStudent.previousStudent;
                        System.out.print(tempStudent + ", ");
                        k--;
                        if (k == 0) {
                            while (true) {
                                if (tempStudent.hub == true) {
                                    tempStudent = tempStudent.previousStudent;
                                    for (k = kk; k == 0; k--) {
                                        System.out.print(tempStudent + ", ");
                                        tempStudent = tempStudent.nextStudent;
                                        if (tempStudent == firstStudent || tempStudent == lastStudent) {
                                            System.exit(0);
                                        }
                                    }

                                } else {
                                    break;
                                }
                            }

                            System.out.println("The message line has ended...");
                            break;
                        }
                    }
                    break;
                }

            } else {
                tempStudent = tempStudent.nextStudent;
            }
        }

    }

    @Override
    public String toString() {
        return firstStudent.toString() + " <->";
    }

}
