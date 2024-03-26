//package com.grygierczyk.services;
//
//import com.grygierczyk.models.NewsTile;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class NewsService {
//    private List<NewsTile> newsTiles;
//
//    public NewsService() {
//        this.newsTiles = new ArrayList<>();
//    }
//
//    public List<NewsTile> getNewsTiles() {
//        return newsTiles;
//    }
//
//   public boolean deleteNewsTile(int id){
//       Iterator<NewsTile> iterator = newsTiles.iterator();
//       while (iterator.hasNext()) {
//           NewsTile newsTile = iterator.next();
//           if (newsTile.getId()==id) {
//               iterator.remove();
//               return true;
//           }
//       }
//       return false;
//   }
//    public void addNewsTile(NewsTile newsTile) {
//        newsTiles.add(newsTile);
//    }
//
//    public Optional<NewsTile> findNewsTileById(int id){
//        return newsTiles.stream().filter(newsTile -> newsTile.getId()==id).findFirst();
//    }
//
//    public boolean editNewsTileById(int id,String newHeader,String newText,byte[] newImage){
//        for (NewsTile newsTile : newsTiles) {
//            if (newsTile.getId() == id) {
//                if (newHeader!=null){
//                newsTile.setHeader(newHeader);}
//                if(newText!=null){
//                newsTile.setText(newText);}
//                if(newImage!=null){
//                newsTile.setImageBytes(newImage);}
//               return true;
//            }
//        }
//        return false;
//    }
//
//}
