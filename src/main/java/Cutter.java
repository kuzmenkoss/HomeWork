//package com.pb.uniwin.cutter;
//
//import java.io.*;
//import java.nio.file.FileVisitOption;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class Main {
//
//    private static List<String> EXCLUDE_DIR = Arrays.asList("build","target",".war",".jar",".idea");
//
//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        System.out.println("Start at " + LocalDateTime.now());
//        AtomicInteger fileCount = new AtomicInteger();
//        try {
//            File base = new File("");
//            File goal = new File(base.getAbsolutePath()+"_cutted");
//// goal.mkdir();
//            System.out.println("Source dir: " + base.getAbsolutePath());
//            System.out.println("Cutted dir: " + goal.getAbsolutePath());
//
//            Files.walk(base.toPath(), FileVisitOption.FOLLOW_LINKS)
//                    .filter(file->{
//
//                        Path parent = file.getParent();
//                        boolean isNotFromExcludeDir = true;
//                        boolean isNotHidden = true;
//                        if(parent != null) {
//                            isNotFromExcludeDir = EXCLUDE_DIR
//                                    .stream()
//                                    .noneMatch( exludeDir->
//                                            parent.startsWith(exludeDir)
//                                                    || parent.toString().contains(exludeDir+File.separator)
//                                                    || parent.endsWith(exludeDir));
//                            isNotHidden = !parent.toString().startsWith(".");
//                        }
//
//                        boolean isFile = file.toFile().isFile();
//
//                        return isNotFromExcludeDir && isNotHidden && isFile;
//                    })
//                    .forEach(file->{
//// System.out.print(file.getParent()+"|");
//                        System.out.print(file.toString());
//                        processAndSaveFile(file, goal);
//                        fileCount.getAndIncrement();
//                    });
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.printf("save %d files, for %d ms\n", fileCount.get(), (System.currentTimeMillis() - start));
//
//    }
//
//    private static void processAndSaveFile(Path from, File goal) {
//        List<String> readedLines = new ArrayList<>();
//        try (FileReader reader = new FileReader(from.toFile())) {
//
//            BufferedReader bufferedReader = new BufferedReader(reader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                readedLines.add(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        final int lineCount = readedLines.size();
//        System.out.println(" : " + lineCount);
//        if(lineCount < 30) {
//            System.out.printf("Skip small file, lineCount=%d, file=%s\n", lineCount, from.toString());
//            return;
//        }
//
//        List<String> writeLines = new ArrayList<>();
//        for(int i = 0; i < readedLines.size(); i++) {
//            boolean isHeader = i < lineCount * 0.2;
//            boolean isBody = i > (lineCount * 0.45) && i < (lineCount * 0.56);
//            boolean isFooter = i > lineCount * 0.8;
//            boolean needWriteLine = isHeader || isBody || isFooter;
//            if(needWriteLine) {
//                writeLines.add(readedLines.get(i));
//            }
//        }
//
//        File newFile;
//        try {
//            newFile = new File(goal.toString(), from.toString());
//            newFile.getParentFile().mkdirs();
//            newFile.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("skip current file");
//            return;
//        }
//
//
//        try(
//                FileWriter writer = new FileWriter(newFile, true);
//                BufferedWriter bufferedWriter = new BufferedWriter(writer);
//        ) {
//
//            writeLines.stream().forEach(line->{
//                try {
//                    bufferedWriter.write(line);
//                    bufferedWriter.newLine();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
