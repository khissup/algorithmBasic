package FileNameChange;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// 가장 하위폴더까지 들어간후, 바로 윗 상위폴더 이름 + 순번에 따라 이름변경
public class FileNameChange {
    public static void main(String[] args) {
        // String strDirPath = "C:\\Users\\UserName\\Desktop\\folder";
        // ListFile( strDirPath );
    }
    private static void ListFile( String strDirPath ) {

        File path = new File( strDirPath );
        File[] fList = path.listFiles();

        for( int i = 0; i < fList.length; i++ ) {

            if( fList[i].isFile() ) {
                // 기존파일
                File file = new File(fList[i].getPath());

                // 기존경로
                String currentPath = file.getPath();
                int startIndex = 0;
                List<Integer> list = new ArrayList<>();
                List<Integer> dotList = new ArrayList<>();
                while(currentPath.indexOf("\\", startIndex) != -1) {
                    list.add(currentPath.indexOf("\\", startIndex));
                    startIndex = currentPath.indexOf("\\", startIndex) + 1;
                }
                // 폴더까지 경로
                String folder = currentPath.substring(0, list.get(list.size() - 1) + 1);

                // 가장 하위파일 담고있는 폴더 이름
                String folderName = currentPath.substring(list.get(list.size() - 2) + 1, list.get(list.size() - 1));

                // 확장자구분하는 . 위치 얻기위한 로직
                String fileName = currentPath.substring(list.get(list.size() -1) + 1);
                startIndex = 0;
                while (fileName.indexOf(".", startIndex) != -1) {
                    dotList.add(fileName.indexOf(".", startIndex));
                    startIndex = fileName.indexOf(".", startIndex) + 1;
                }

                // 확장자
                String extension = fileName.substring(dotList.get(dotList.size() - 1));

                // 최종경로 = 폴더까지 경로 + 폴더 이름 + "_" + 인덱스 + 확장자
                String newName = folder + folderName + "_" + (i + 1) + extension;

                File newFile = new File(newName);

                boolean result = file.renameTo(newFile);
                if(result == false) {
                    System.out.println("이름바꾸기 실패");
                }
            }
            else if( fList[i].isDirectory() ) {
                ListFile( fList[i].getPath() );  // 재귀함수 호출
            }
        }
    }
}
