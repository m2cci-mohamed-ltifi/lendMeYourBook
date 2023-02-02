package com.education.lendmeyourbook.services;

import com.education.lendmeyourbook.entities.*;
import com.education.lendmeyourbook.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class DonationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private BookCategoryRepository bookCategoryRepository;
    @Autowired
    private SchoolHasBookRepository schoolHasBookRepository;


    @Transactional
    public void registerDonation(Donation donation) {
        School donationSchool = donation.getSchool();
        List<School> dbSchool = this.schoolRepository.findByNameAndAndCityId(donationSchool.getName(), donationSchool.getCity().getId());
        if (dbSchool.size()> 0) {
            donation.setSchool(dbSchool.get(0));
        }
        this.schoolRepository.saveAndFlush(donation.getSchool());
        this.registerBooksForSchool(donation.getBooks(), donation.getSchool());
        this.userRepository.saveAndFlush(donation.getUser());
    }

    public void registerBooksForSchool(List<Book> books, School school) {

        for (Book book : books) {
            if (book.getName() == null) {
                book.setName(book.getCategory().getName().toString() + "كتاب");
            }
            BookCategory donationBookCategory = book.getCategory();
            List<BookCategory> categories = bookCategoryRepository.findBookCategoryByNameAndTypeAndLevel(
                    donationBookCategory.getName(),
                    donationBookCategory.getType(),
                    donationBookCategory.getLevel()
            );
            if (categories.size() > 0) {
                donationBookCategory = categories.get(0);
            } else {
                donationBookCategory = this.bookCategoryRepository.saveAndFlush(donationBookCategory);
            }
            book.setCategory(donationBookCategory);

            List<Book> dbBooks = this.bookRepository.findBookByNameAndCategoryId(book.getName(), book.getCategory().getId());
            if (dbBooks.size() > 0) {
                book = dbBooks.get(0);
                List<SchoolHasBook> schoolHasBooks = this.schoolHasBookRepository.findSchoolHasBookBySchoolIdAndBookId(school.getId(), book.getId());

                SchoolHasBook schoolHasBook = new SchoolHasBook();
                if (schoolHasBooks.size() > 0) {
                    schoolHasBook = schoolHasBooks.get(0);
                    schoolHasBook.setTotalNumber(schoolHasBooks.get(0).getTotalNumber() + 1);
                } else {
                    schoolHasBook.setBook(book);
                    schoolHasBook.setSchool(school);
                    schoolHasBook.setTotalNumber(1);
                }
                this.schoolHasBookRepository.saveAndFlush(schoolHasBook);
            } else {
                book = this.bookRepository.saveAndFlush(book);
                SchoolHasBook schoolHasBook = new SchoolHasBook();
                schoolHasBook.setSchool(school);
                schoolHasBook.setBook(book);
                schoolHasBook.setTotalNumber(1);
                this.schoolHasBookRepository.saveAndFlush(schoolHasBook);
            }
        }

    }
}
